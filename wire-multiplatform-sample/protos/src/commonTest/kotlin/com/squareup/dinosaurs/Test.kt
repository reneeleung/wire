/*
 * Copyright 2019 Square Inc.
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
package com.squareup.dinosaurs

import kotlin.test.Test
import okio.ByteString.Companion.toByteString
import com.squareup.geology.Period.JURASSIC

class Test {
  @Test fun dino() {
      val stegosaurus = Dinosaur(
          name = "Stegosaurus",
          period = JURASSIC,
          length_meters = 9.0,
          mass_kilograms = 5000.0,
          picture_urls = listOf("http://goo.gl/LD5KY5", "http://goo.gl/VYRM67")
      )
      throw RuntimeException(Dinosaur.ADAPTER.encode(stegosaurus).toByteString().base64())
  }
}
