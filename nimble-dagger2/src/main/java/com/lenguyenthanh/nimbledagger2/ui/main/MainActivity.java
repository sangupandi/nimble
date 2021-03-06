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

import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.lenguyenthanh.nimbledagger2.DaggerApplication;
import com.lenguyenthanh.nimbledagger2.R;
import com.lenguyenthanh.nimbledagger2.ui.base.BaseActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainView> implements MainView {

  @Bind(R.id.tvContent)
  TextView tvContent;

  @Inject
  MainPresenter presenter;

  @Override
  protected MainPresenter presenter() {
    return presenter;
  }

  @Override
  protected int layoutId() {
    return R.layout.activity_main;
  }

  @Override
  protected void buildComponent(DaggerApplication.AppComponent appComponent) {
    MainActivityComponent component = DaggerMainActivityComponent.builder()
        .mainActivityModule(new MainActivityModule(this))
        .appComponent(appComponent)
        .build();
    component.inject(this);
  }

  @OnClick(R.id.fab)
  void fabClicked() {
    presenter().getUser();
  }

  @Override
  public void sayHello(String name) {
    tvContent.setText(String.format("Hello %s", name));
  }
}
