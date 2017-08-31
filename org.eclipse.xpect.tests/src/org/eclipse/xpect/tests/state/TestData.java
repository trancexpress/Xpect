/*******************************************************************************
 * Copyright (c) 2012-2017 TypeFox GmbH and itemis AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Moritz Eysholdt - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xpect.tests.state;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.eclipse.xpect.state.Creates;
import org.eclipse.xpect.state.Managed;
import org.eclipse.xpect.state.ManagedImpl;
import org.eclipse.xpect.state.XpectStateAnnotation;

public class TestData {
	public static class StaticValueProvider {
		@Creates
		public String getDefaultValue() {
			return "DefaultValue";
		}

		@Creates(Ann.class)
		public String getAnnotatedValue() {
			return "AnnotatedValue";
		}
	}

	public static class StaticManagedProvider {

		@Creates
		public Managed<String> getDefaultManaged() {
			return new ManagedImpl<String>("DefaultManaged");
		}

		@Creates(Ann.class)
		public Managed<String> getAnnotatedManaged() {
			return new ManagedImpl<String>("AnnotatedManaged");
		}
	}

	@XpectStateAnnotation
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Ann {
	}

}
