package dataReceiver;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class DataReceiver {
	public void receive() {
		ConnectionFactory factory = new ConnectionFactory();  
			
		factory.setHost("localhost");  
		factory.setUsername("guest");  
		factory.setPassword("guest");  
		
		try {
			//ミ硈挡
			Connection conn = factory.newConnection();
			// ミ硄笵
	        Channel channel = conn.createChannel();
	        
	        String queueName = "test queue";
	        
	        // ︻ま计弧ま计︻嘿ま计琌てま计琌縒家Αま计禣耞秨硈絬琌埃︻ま计き癟ㄤま计
	        channel.queueDeclare(queueName, false, false, false, null);

	        // ミ璹綷竟钡癟
	        channel.basicConsume(queueName, false, "", new DefaultConsumer(channel) {
	        	@Override
		        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,byte[] body) throws IOException {
		        	String routingKey = envelope.getRoutingKey(); // ︻嘿
		            String contentType = properties.getContentType(); // ず甧
		            String content = new String(body, "utf-8"); // 癟タゅ
		            System.out.println("癟タゅ"+content);
		            channel.basicAck(envelope.getDeliveryTag(), false); // も笆絋粄癟ま计弧ま计赣癟indexま计琌у秖莱氮trueу秖絋粄index癟
	        	}
	        });
			
		} catch (Exception e) {
	           e.printStackTrace();
	    }
	}
}
