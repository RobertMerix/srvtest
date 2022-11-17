package org.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    Datasource datasource;


    public ServerHandler(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("[CONNECTED] -> " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buffed = (ByteBuf) msg;

        String sentence = buffed.toString(CharsetUtil.UTF_8);

        if (sentence.contains("imei") && sentence.length() <= 30) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("LOAD", CharsetUtil.UTF_8));
        } else if (!sentence.isEmpty() && Character.isDigit(sentence.charAt(0))) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("ON", CharsetUtil.UTF_8));
        } else {
            datasource.insertPosition(sentence);
            System.out.println(sentence);
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        // shouldn't close database connection here, however since I'm connected to one GPS
        // its fine for now.
        datasource.close();
        System.out.println("[DISCONNECTED] " + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
