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
package com.lenguyenthanh.nimble.view;

import android.os.Bundle;
import com.lenguyenthanh.nimble.NimblePresenter;
import com.lenguyenthanh.nimble.NimbleView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class NimbleActivityTest {

  @Mock
  NimblePresenter<NimbleView> presenter;
  @Mock
  Bundle bundle;
  NimbleActivity<NimbleView> activity;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    activity = Mockito.spy(TestActivity.class);
    ((TestActivity) activity).setPresenter(presenter);
  }

  @Test
  public void testOnCreate() throws Exception {
    activity.onCreate(bundle);
    verify(presenter).takeView(Mockito.any(NimbleView.class));
    verify(presenter).onCreate(bundle);
  }

  @Test
  public void testOnResume() throws Exception {
    activity.onResume();
    verify(presenter).takeView(activity);
  }

  @Test
  public void testOnPause() throws Exception {
    activity.onPause();
    verify(presenter).dropView(activity);
  }

  @Test
  public void testOnSaveInstanceState() throws Exception {
    activity.onSaveInstanceState(bundle);
    verify(presenter).onSave(bundle);
  }

  @Test
  public void testOnDestroy() throws Exception {
    activity.onDestroy();
    verify(presenter).onDestroy();
  }

  public static class TestActivity extends NimbleActivity<NimbleView> {

    private NimblePresenter<NimbleView> presenter;

    public void setPresenter(NimblePresenter<NimbleView> presenter) {
      this.presenter = presenter;
    }

    @Override
    protected NimblePresenter<NimbleView> presenter() {
      return presenter;
    }

    @Override
    protected int layoutId() {
      return -1;
    }
  }
}
