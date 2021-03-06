/*******************************************************************************
 * Copyright (c) 2009, 2020 Mountainminds GmbH & Co. KG and Contributors
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Evgeny Mandrikov - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.test.validation.java14.targets;

/**
 * This target exercises records.
 */
public class RecordsTarget {

	private record WithoutFields() { // assertFullyCovered()
	}

	private record WithFields( // assertPartlyCovered()
			int x // assertEmpty()
	) {
	}

	private record WithCustomMethods(int x) { // assertFullyCovered()
		public int x() {
			return x; // assertNotCovered()
		}

		public String toString() {
			return ""; // assertNotCovered()
		}

		public int hashCode() {
			return 0; // assertNotCovered()
		}

		public boolean equals(Object object) {
			return false; // assertNotCovered()
		}
	}

	public static void main(String[] args) {
		new WithoutFields();
		new WithFields(42);
		new WithCustomMethods(42);
	}

}
