package org.zkpk.hadoop.day0804.ex;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileSystemDoubleCat {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String uri=args[0];
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(URI.create(uri),conf);
		FSDataInputStream in=null;
		in=fs.open(new Path(uri));
		IOUtils.copyBytes(in,System.out,4096,false);
		in.seek(0);
		IOUtils.copyBytes(in,System.out,4096,false);
		IOUtils.closeStream(in);
	}

}
