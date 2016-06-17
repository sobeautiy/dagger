/*
 * Copyright (C) 2015 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.subcomponent;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
final class GrandchildModule {
  @Provides
  @IntoSet
  static Object provideUnscopedObject() {
    return new Object() {
      @Override public String toString() {
        return "unscoped in grandchild";
      }
    };
  }

  @Provides
  static AnInterface provideAnInterface(ImplementsAnInterface implementsAnInterface) {
    return implementsAnInterface;
  }

  @Provides
  static NeedsAnInterface provideNeedsAnInterface(AnInterface anInterface) {
    return new NeedsAnInterface(anInterface);
  }
}
