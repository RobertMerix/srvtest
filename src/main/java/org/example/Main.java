package org.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Main {

    private final int port;
    private static final Datasource datasource = new Datasource();

    public Main(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println(Main.class.getName() + " missing <port>");
        }


        if (!datasource.open()) {
            System.out.println("[DB-ERROR] Can't open datasource");
        }

        final int port = Integer.parseInt(args[0]);

        new Main(port).start();
     }


     public void start() throws Exception {
         EventLoopGroup bossGroup = new NioEventLoopGroup();
         EventLoopGroup workerGroup = new NioEventLoopGroup();

         try {
             ServerBootstrap b = new ServerBootstrap();
             b.group(bossGroup, workerGroup)
                     .channel(NioServerSocketChannel.class)
                     .localAddress(port)
                     .childHandler(new ChannelInitializer<SocketChannel>() {
                         @Override
                         protected void initChannel(SocketChannel socketChannel) throws Exception {
                             ChannelPipeline pipeline = socketChannel.pipeline();

//                             pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//                             pipeline.addLast(new StringDecoder());
//                             pipeline.addLast(new StringEncoder());
                             pipeline.addLast(new ServerHandler(datasource));
                         }
                     });

             ChannelFuture f = b.bind().sync();
             System.out.println("[LISTENING] " + f.channel().localAddress());
             f.channel().closeFuture().sync();
         } finally {
             bossGroup.shutdownGracefully();
             workerGroup.shutdownGracefully();
         }
     }

}