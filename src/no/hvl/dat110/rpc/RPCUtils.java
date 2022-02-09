package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;

public class RPCUtils {

	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = new byte[payload.length + 1];
		rpcmsg[0] = rpcid;
		if (payload != null) {
			int i = 0;
			for (byte p : payload) {
				i++;
				rpcmsg[i] = p;

			}
		}

		return rpcmsg;
	}

	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = rpcmsg;
		if (rpcmsg != null && rpcmsg.length > 0) {
			payload = new byte[rpcmsg.length-1];
			for (int i = 0; i < payload.length; i++) {
				payload[i] = rpcmsg[i + 1];
			}
		}
		return payload;

	}

	public static byte[] marshallString(String str) {

		byte[] encoded = null;

		encoded = str.getBytes();

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = null;

		decoded = new String(data);

		return decoded;
	}

	public static byte[] marshallVoid() {

		byte[] encoded = null;

		encoded = new byte[0];

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		data = new byte[0];

	}

	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else {
			encoded[0] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	public static byte[] marshallInteger(int x) {

		byte[] encoded = null;

		encoded = ByteBuffer.allocate(4).putInt(x).array();

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded = 0;

		decoded = ByteBuffer.wrap(data).getInt();

		return decoded;

	}
}
