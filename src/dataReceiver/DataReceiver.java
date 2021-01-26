package dataReceiver;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import org.json.*;

public class DataReceiver extends Thread{
	public JSONArray dataArr;
	
	public void run() {
		receive();
	}
	public void receive() {
		ConnectionFactory factory = new ConnectionFactory();  
			
		factory.setHost("localhost");  
		factory.setUsername("guest");  
		factory.setPassword("guest");  
		
		try {
			//�إ߳s��
			Connection conn = factory.newConnection();
			// �إ߳q�D
	        Channel channel = conn.createChannel();
	        
	        String queueName = "test queue";
	        
	        // �ŧi��C�i�޼ƻ����G�޼Ƥ@�G��C�W�١A�޼ƤG�G�O�_���[�ơF�޼ƤT�G�O�_�W���Ҧ��F�޼ƥ|�G���O���_�}�s�u�ɬO�_�R����C�F�޼Ƥ��G�T����L�޼ơj
	        channel.queueDeclare(queueName, false, false, false, null);

	        // �إ߭q�\���A�ñ����T��
	        channel.basicConsume(queueName, false, "", new DefaultConsumer(channel) {
	        	@Override
		        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,byte[] body) throws IOException {
		        	String routingKey = envelope.getRoutingKey(); // ��C�W��
		            String contentType = properties.getContentType(); // ���e���O
		            String content = new String(body, "utf-8"); // �T������
		            JSONObject jsonObj = new JSONObject(content);
		            dataArr = jsonObj.getJSONArray("cnts");
//		            System.out.println("�T������G"+content);
		            channel.basicAck(envelope.getDeliveryTag(), false); // ��ʽT�{�T���i�޼ƻ����G�޼Ƥ@�G�ӰT����index�F�޼ƤG�G�O�_��q�����Atrue��q�T�{�p��index���T���j
	        	}
	        });
			
		} catch (Exception e) {
	           e.printStackTrace();
	    }
	}
	
	public JSONArray getDataArray() {
		return dataArr;
	}
}
