// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 <LICENSE-APACHE or
// https://www.apache.org/licenses/LICENSE-2.0> or the MIT license
// <LICENSE-MIT or https://opensource.org/licenses/MIT>, at your
// option. This file may not be copied, modified, or distributed
// except according to those terms.

package beam.starter

import org.apache.beam.sdk.testing.PAssert
import org.apache.beam.sdk.testing.TestPipeline
import org.junit.Rule
import org.junit.Test

class AppTest {
    val pipeline = TestPipeline.create()
    @Rule public fun pipelineRule() = pipeline

    @Test
    fun appHasAGreeting() {
        val elements = buildPipeline(pipeline, "Test")

        // Note that the order of the elements doesn't matter.
        PAssert.that(elements).containsInAnyOrder("Test", "Hello", "World!")
        pipeline.run().waitUntilFinish()
    }
}
