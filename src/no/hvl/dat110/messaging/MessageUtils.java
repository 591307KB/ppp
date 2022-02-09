package no.hvl.dat110.messaging;


public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		segment[0]=(byte) data.length;
		int i=0;
		for(byte d : data) {
			i++;
			segment[i]=d;
			
		}
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		int length = segment[0];

		byte[] data = new byte[length];
		for(int i = 0 ; i < length;i++) {
			data[i]=segment[i+1];
		}
		Message message= new Message(data);
		
		return message;
		
	}
	
}
