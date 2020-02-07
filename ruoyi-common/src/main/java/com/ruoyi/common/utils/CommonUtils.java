package com.ruoyi.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.util.CollectionUtils;

/**
 * 公用工具类
 */
public class CommonUtils {

	/**
	 * 600属性
	 */
	public static final int MAX_QUERY_SIZE = 600;

	/**
	 * [数据分批操作]
	 * 
	 * @param data
	 *            入参
	 * @return List<List<T>> 多批数据
	 */
	public static <T> List<List<T>> traversaGroup(List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return new ArrayList<List<T>>();
        }
        List<List<T>> result = new ArrayList<List<T>>();
//        int num=0;
//		int tar=0;
//		Stream.iterate(0, num -> num + 1).limit(countStep(data.size())).forEach(tar -> result
//            .add(data.stream().skip(tar * MAX_QUERY_SIZE).limit(MAX_QUERY_SIZE).collect(Collectors.toList())));
        return result;
    }

	/**
	 * 深度拷贝list
	 * 
	 * @param srcList
	 *            srcList参数变量
	 * @return 结果信息
	 * @throws IOException
	 *             IOException异常信息
	 * @throws ClassNotFoundException
	 *             ClassNotFoundException异常信息
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> depCopy(List<T> srcList) throws IOException,
			ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(srcList);
		ByteArrayInputStream byteIn = new ByteArrayInputStream(
				byteOut.toByteArray());
		ObjectInputStream inStream = new ObjectInputStream(byteIn);
		List<T> destList = (List<T>) inStream.readObject();
		return destList;
	}

	/**
	 * 计算切分次数
	 * 
	 * @param size
	 *            size参数变量
	 * @return 结果信息
	 */
	private static Integer countStep(Integer size) {
		return (size + MAX_QUERY_SIZE - 1) / MAX_QUERY_SIZE;
	}

	/**
	 * 
	 * [将输入流转换成字节]
	 * 
	 * @param inputStream
	 *            输入流
	 * @return 字节数组
	 * @throws ApplicationException
	 *             [异常]
	 */
	public static byte[] readStreamToByte(InputStream inputStream)
			throws Exception {
		byte[] buffer = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			byte[] bs = new byte[1024];
			int num;
			while ((num = inputStream.read(bs)) != -1) {
				baos.write(bs, 0, num);
			}
			buffer = baos.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException("readStreamToByte failed: "
					+ e.getMessage());
		} finally {
			if (null != baos) {
				try {
					baos.close();
				} catch (IOException e) {
					throw new RuntimeException("readStreamToByte failed: "
							+ e.getMessage());
				}
			}
		}
		return buffer;
	}
}