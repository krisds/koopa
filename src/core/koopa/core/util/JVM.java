package koopa.core.util;

import java.security.Permission;

public class JVM {

	// Thank you, sbridges and Stack Overflow !
	// http://stackoverflow.com/questions/5401281/preventing-system-exit-from-api

	public static class ExitTrappedException extends SecurityException {
		private static final long serialVersionUID = 1L;
	}

	public static void forbidSystemExitCall() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().startsWith("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}

	public static void enableSystemExitCall() {
		System.setSecurityManager(null);
	}
}
