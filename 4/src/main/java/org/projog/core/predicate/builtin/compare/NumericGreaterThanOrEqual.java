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
package org.projog.core.predicate.builtin.compare;

import org.projog.core.term.Term;

/* TEST
%TRUE 2>=1
%TRUE 2>=2
%FAIL 2>=3
%TRUE 3-1>=1
%TRUE 1+1>=4-2
%FAIL 8/4>=9/3
%TRUE 1.5>=3.0/2.0

%TRUE 7>=7.0
%TRUE 7.0>=7
%TRUE 7.0>=7.0
%TRUE 7.5>=7.5

%FAIL 7.4999>=7.5
%TRUE 7.5001>=7.5

%FAIL 7>=7.5
%FAIL 7>=7.0001
%FAIL 6.9999>=7

%TRUE 8>=7.5
%TRUE 8>=7.9999
%TRUE 8.0001>=8

%FAIL 9223372036854775806 >= 9223372036854775807
%TRUE 9223372036854775807 >= 9223372036854775806
%TRUE 9223372036854775807 >= 9223372036854775807
%TRUE 9223372036854775806 >= 9223372036854775806

%FAIL -9223372036854775808 >= -9223372036854775807
%TRUE -9223372036854775807 >= -9223372036854775808
%TRUE -9223372036854775808 >= -9223372036854775808
%TRUE -9223372036854775807 >= -9223372036854775807
*/
/**
 * <code>X&gt;=Y</code> - numeric "greater than or equal" test.
 * <p>
 * Succeeds when the number argument <code>X</code> is greater than or equal to the number argument <code>Y</code>.
 * </p>
 */
public final class NumericGreaterThanOrEqual extends AbstractNumericComparisonPredicate {
   @Override
   protected boolean evaluate(Term arg1, Term arg2) {
      return compare(arg1, arg2) > -1;
   }
}
