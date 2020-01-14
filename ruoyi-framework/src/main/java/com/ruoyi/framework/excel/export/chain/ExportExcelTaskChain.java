package com.ruoyi.framework.excel.export.chain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.framework.excel.export.common.TaskVO;
import com.ruoyi.framework.validator.Exception.ApplicationException;
/**
 * 任务链
 * @author paul
 *
 */
public abstract class ExportExcelTaskChain extends ExportExcelChain {

	/**
	 * 插入一条新的任务
	 * 
	 * @param request
	 * @return
	 * @throws ApplicationException
	 */
	private TaskVO insertNewTask(HttpServletRequest request)
			throws ApplicationException {
		System.out.println("插入一条新的任务");
		return new TaskVO();

	}

	/**
	 * 将任务更新为成功
	 * 
	 * @param task
	 * @throws ApplicationException
	 */
	private void updateTaskSuccess(TaskVO task) throws ApplicationException {
		System.out.println("将任务更新为成功");
	}

	/**
	 * 将任务更新为处理中
	 * 
	 * @param task
	 * @throws ApplicationException
	 */
	private void updateTaskProcessing(TaskVO task) throws ApplicationException {
		System.out.println("将任务更新为处理中");
	}

	/**
	 * 将任务更新为失败
	 * 
	 * @param task
	 * @throws ApplicationException
	 */
	private void updateTaskFailed(TaskVO task) throws ApplicationException {
		System.out.println("将任务更新为失败");
	}

	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		TaskVO task = null;
		try {
			task = insertNewTask(request);
			updateTaskProcessing(task);
			export2(request,response);
			updateTaskSuccess(task);
		} catch (Exception e) {
			updateTaskFailed(task);
		}

	}

	/**
	 * 接下来的处理
	 * @param request
	 * @param response
	 * @throws ApplicationException
	 */
	public abstract void export2(HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException;
}
