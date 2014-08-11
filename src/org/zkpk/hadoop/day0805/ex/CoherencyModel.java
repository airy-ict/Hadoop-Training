package org.zkpk.hadoop.day0805.ex;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CoherencyModel {
	public static void main(String[] args) throws IOException {
		String uri=args[0];
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(URI.create(uri),conf);
		Path p=new Path(uri);
		FSDataOutputStream out=fs.create(p);
		out.write("contentffff".getBytes("UTF-8"));
		out.flush();
		//out.sync();
		assertThat(fs.getFileStatus(p).getLen(),is(((long)"content".length())));
	}

	private static boolean assertThat(long len, long l) {
		// TODO Auto-generated method stub
		if(len==l){
			return true;
		}
		else
			return false;
	}

	private static long is(long l) {
		// TODO Auto-generated method stub
		return l;
	}



}
