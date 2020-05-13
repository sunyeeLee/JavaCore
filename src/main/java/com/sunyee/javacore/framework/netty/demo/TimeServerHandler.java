package com.sunyee.javacore.framework.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Date;


/**
 * Created by lishunyi on 2019/9/3
 */
public class TimeServerHandler extends ChannelHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuffer readBuffer = (ByteBuffer) msg;
        byte[] req = new byte[readBuffer.remaining()];
        readBuffer.get(req);
        try {
            String body = new String(req, "UTF-8");
            System.out.println("the time server receive order: " + body);
            String response = "Query Time BookingService".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "Bad BookingService";
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            ctx.write(writeBuffer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }
}
