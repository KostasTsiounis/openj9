/*[INCLUDE-IF JAVA_SPEC_VERSION >= 8]*/
/*
 * Copyright IBM Corp. and others 2005
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
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0-only WITH Classpath-exception-2.0 OR GPL-2.0-only WITH OpenJDK-assembly-exception-1.0
 */
package java.lang.management;

import java.util.List;

/**
 * The management interface for the logging facility.
 * <p>
 * Precisely one instance of this interface will be made available to management
 * clients.
 * </p>
 * <p>
 * Accessing this <code>MXBean</code> can be done in one of three ways.
 * <ol>
 * <li>Invoking the static {@link ManagementFactory#getPlatformMXBean} method.
 * </li>
 * <li>Using a javax.management.MBeanServerConnection.</li>
 * <li>Obtaining a proxy MXBean from the static
 * {@link ManagementFactory#newPlatformMXBeanProxy} method, passing in
 * &quot;java.util.logging:type=Logging&quot; for the value of the second parameter.
 * </li>
 * </ol>
 *
 * @since 1.5
 */
/*[IF JAVA_SPEC_VERSION >= 17]*/
@SuppressWarnings("doclint:reference")
/*[ENDIF] JAVA_SPEC_VERSION >= 17 */
public interface PlatformLoggingMXBean extends PlatformManagedObject{

	/**
	 * Returns the string name of the specified
	/*[IF JAVA_SPEC_VERSION >= 17]
	 * {@link java.logging/java.util.logging.Logger}
	/*[ELSE] JAVA_SPEC_VERSION >= 17
	 * {@link java.util.logging.Logger}
	/*[ENDIF] JAVA_SPEC_VERSION >= 17
	 * instance's current log level.
	 *
	 * @param loggerName
	 *            the name of a particular <code>Logger</code> instance
	 * @return if <code>loggerName</code> resolves to an existing registered
	 *         <code>Logger</code> instance, the log level of that instance.
	 *         Note that if it is the case that the <code>Logger</code> just
	 *         inherits its log level rather than specifying its own, then an
	 *         empty string (<code>&quot;&quot;</code>) will be returned. If
	 *         <code>loggerName</code> does not resolve to a registered
	 *         instance of <code>Logger</code> then a <code>null</code>
	 *         value is returned.
	 */
	public String getLoggerLevel(String loggerName);

	/**
	 * Returns a list of the names of all of the currently registered
	 * <code>Logger</code> instances.
	 * @return a list of the names of all registered <code>Logger</code> objects.
	 */
	public List<String> getLoggerNames();

	/**
	 * Returns the name of the parent
	/*[IF JAVA_SPEC_VERSION >= 17]
	 * {@link java.logging/java.util.logging.Logger}
	/*[ELSE] JAVA_SPEC_VERSION >= 17
	 * {@link java.util.logging.Logger}
	/*[ENDIF] JAVA_SPEC_VERSION >= 17
	 * of the specified registered <code>Logger</code>,<code>loggerName</code>.
	 *
	 * @param loggerName
	 *            the name of a particular <code>Logger</code> instance
	 * @return if <code>loggerName</code> resolves to an existing registered
	 *         <code>Logger</code> instance, the name of its parent
	 *         <code>Logger</code>. If the <code>Logger</code> is the root
	 *         entry in the <code>Logger</code> hierarchy, then an empty
	 *         string (<code>&quot;&quot;</code>) will be returned. If
	 *         <code>loggerName</code> does not resolve to a registered
	 *         instance of <code>Logger</code> then a <code>null</code>
	 *         value is returned.
	 */
	public String getParentLoggerName(String loggerName);

	/**
	 * Attempts to update the log level of the
	/*[IF JAVA_SPEC_VERSION >= 17]
	 * {@link java.logging/java.util.logging.Logger}
	/*[ELSE] JAVA_SPEC_VERSION >= 17
	 * {@link java.util.logging.Logger}
	/*[ENDIF] JAVA_SPEC_VERSION >= 17
	 * with name <code>loggerName</code> to <code>levelName</code>.
	 * <p>
	 * If <code>levelName</code> is <code>null</code> then the <code>Logger</code>
	 * instance's log level is set to be <code>null</code> with the result that
	 * it will inherit its log level from its nearest parent which does not have
	 * a <code>null</code> log level value.
	 * </p>
	 * @param loggerName the name of a registered <code>Logger</code>
	 * @param levelName the name of the new log level. May be <code>null</code>,
	 * in which case <code>loggerName</code> will inherit the log level of its
	 * closest parent with a non-<code>null</code> log level.
	 * @throws IllegalArgumentException if there is no <code>Logger</code>
	 * with the name <code>loggerName</code>. Also may be thrown if
	 * <code>loggerName</code> is not a known log level name.
	/*[IF JAVA_SPEC_VERSION < 24]
	 * @throws SecurityException if there is a security manager active and
	 * the caller does not have
	/*[IF JAVA_SPEC_VERSION >= 17]
	 * {@link java.logging/java.util.logging.LoggingPermission}
	/*[ELSE] JAVA_SPEC_VERSION >= 17
	 * {@link java.util.logging.LoggingPermission}
	/*[ENDIF] JAVA_SPEC_VERSION >= 17
	 * of &quot;control&quot;.
	/*[ENDIF] JAVA_SPEC_VERSION < 24
	 */
	public void setLoggerLevel(String loggerName, String levelName);

}
