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
package org.projog.core.predicate;

import org.projog.core.kb.KnowledgeBase;
import org.projog.core.predicate.udp.PredicateUtils;
import org.projog.core.term.Term;

/**
 * Represents all predicates that a {@code KnowledgeBase} has no definition of.
 * <p>
 * Always fails to evaluate successfully.
 *
 * @see Predicates#getPredicateFactory(PredicateKey)
 * @see Predicates#getPredicateFactory(Term)
 */
public final class UnknownPredicate implements PreprocessablePredicateFactory {
   private final KnowledgeBase kb;
   private final PredicateKey key;
   private PredicateFactory actualPredicateFactory; //  TODO update Javadoc to explain actualPredicateFactory

   public UnknownPredicate(KnowledgeBase kb, PredicateKey key) {
      this.kb = kb;
      this.key = key;
   }

   @Override
   public Predicate getPredicate(Term[] args) {
      instantiatePredicateFactory();

      if (actualPredicateFactory == null) {
         return PredicateUtils.FALSE;
      } else {
         return actualPredicateFactory.getPredicate(args);
      }
   }

   @Override
   public PredicateFactory preprocess(Term arg) {
      instantiatePredicateFactory();

      if (actualPredicateFactory == null) {
         return this;
      } else if (actualPredicateFactory instanceof PreprocessablePredicateFactory) {
         return ((PreprocessablePredicateFactory) actualPredicateFactory).preprocess(arg);
      } else {
         return actualPredicateFactory;
      }
   }

   private void instantiatePredicateFactory() {
      if (actualPredicateFactory != null) {
         return;
      }

      synchronized (key) {
         if (actualPredicateFactory == null) {
            PredicateFactory pf = kb.getPredicates().getPredicateFactory(key);
            if (pf instanceof UnknownPredicate) {
               kb.getProjogListeners().notifyWarn("Not defined: " + key);
            } else {
               actualPredicateFactory = pf;
            }
         }
      }
   }

   @Override
   public boolean isRetryable() {
      return true;
   }
}
