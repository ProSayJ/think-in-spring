package prosayj.handwritingspring.simulate.beans.expection;

import prosayj.handwritingspring.simulate.core.expection.NestedRuntimeException;
import prosayj.handwritingspring.simulate.core.lang.Nullable;

@SuppressWarnings("serial")
public abstract class BeansException extends NestedRuntimeException {

	/**
	 * Create a new BeansException with the specified message.
	 * @param msg the detail message
	 */
	public BeansException(String msg) {
		super(msg);
	}

	/**
	 * Create a new BeansException with the specified message
	 * and root cause.
	 * @param msg the detail message
	 * @param cause the root cause
	 */
	public BeansException(@Nullable String msg, @Nullable Throwable cause) {
		super(msg, cause);
	}

}