/*
 * Copyright 2016 Thanh Le.
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
package com.lenguyenthanh.nimbledagger2.ui.main;

import com.lenguyenthanh.nimbledagger2.DaggerApplication;
import com.lenguyenthanh.nimbledagger2.scope.ActivityScope;

@dagger.Component(dependencies = DaggerApplication.AppComponent.class,
    modules = MainActivityModule.class)
@ActivityScope
public interface MainActivityComponent {
  void inject(MainActivity mainActivity);
}

