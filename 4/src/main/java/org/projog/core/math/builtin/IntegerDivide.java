/*
 * Copyright 2013 S. Webber
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.projog.core.math.builtin;

import org.projog.core.math.AbstractBinaryIntegerArithmeticOperator;

/* TEST
%LINK prolog-arithmetic
*/
/**
 * <code>//</code> - performs integer division.
 * <p>
 * The result will be rounded towards zero. e.g. <code>7 // 2</code> is rounded down to <code>3</code> while
 * <code>-7 // 2</code> is rounded up to <code>-3</code>
 */
public final class IntegerDivide extends AbstractBinaryIntegerArithmeticOperator {
   @Override
   protected long calculateLong(long dividend, long divisor) {
      return dividend / divisor;
   }
}
