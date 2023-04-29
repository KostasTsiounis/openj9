/*[INCLUDE-IF JAVA_SPEC_VERSION >= 20]*/
/*******************************************************************************
 * Copyright IBM Corp. and others 2021
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at https://www.eclipse.org/legal/epl-2.0/
 * or the Apache License, Version 2.0 which accompanies this distribution and
 * is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following
 * Secondary Licenses when the conditions for such availability set
 * forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
 * General Public License, version 2 with the GNU Classpath
 * Exception [1] and GNU General Public License, version 2 with the
 * OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] https://openjdk.org/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
 *******************************************************************************/
package jdk.internal.foreign.abi;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.lang.foreign.FunctionDescriptor;
import jdk.internal.foreign.abi.LinkerOptions;
/*[IF JAVA_SPEC_VERSION == 20]*/
import openj9.internal.foreign.abi.InternalDowncallHandler;
/*[ENDIF] JAVA_SPEC_VERSION == 20 */

/**
 * The counterpart in OpenJDK is replaced with this class that wrap up a method handle
 * enabling the native code to the ffi_call via the libffi interface at runtime.
 */
public class DowncallLinker {
	/**
	 * The method is ultimately invoked by Linker on the specific platforms to generate the requested
	 * method handle to the underlying C function.
	 *
	 * @param functionMethodType The MethodType of the specified native function
	 * @param funcDesc The function descriptor of the specified native function
	 * @param options The linker options indicating additional linking requirements to the linker
	 * @return a method handle bound to the native method
	 */
	@SuppressWarnings("nls")
	public static MethodHandle getBoundMethodHandle(MethodType functionMethodType, FunctionDescriptor funcDesc, LinkerOptions options) {
		/*[IF JAVA_SPEC_VERSION >= 21]*/
		throw new InternalError("Downcall is not yet implemented");
		/*[ELSE] JAVA_SPEC_VERSION >= 21 */
		return new InternalDowncallHandler(functionMethodType, funcDesc, options).getBoundMethodHandle();
		/*[ENDIF] JAVA_SPEC_VERSION >= 21 */
	}
}
