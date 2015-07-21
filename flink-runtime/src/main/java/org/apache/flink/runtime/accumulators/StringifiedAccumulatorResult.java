/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.runtime.accumulators;

import org.apache.flink.api.common.accumulators.Accumulator;

/**
 * Container class that transports the result of an accumulator as set of strings.
 */
public class StringifiedAccumulatorResult implements java.io.Serializable{

	private static final long serialVersionUID = -4642311296836822611L;

	private final String name;
	private final String type;
	private final String value;

	public StringifiedAccumulatorResult(String name, String type, String value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	public StringifiedAccumulatorResult(String name, Accumulator<?, ?> accumulator) {
		this.name = name;
		this.type = accumulator == null ? null : accumulator.getClass().getSimpleName();
		this.value = accumulator == null ? null : accumulator.toString();
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}
}
