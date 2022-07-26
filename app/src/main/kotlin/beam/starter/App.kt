// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 <LICENSE-APACHE or
// https://www.apache.org/licenses/LICENSE-2.0> or the MIT license
// <LICENSE-MIT or https://opensource.org/licenses/MIT>, at your
// option. This file may not be copied, modified, or distributed
// except according to those terms.

package beam.starter

import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.options.Default
import org.apache.beam.sdk.options.Description
import org.apache.beam.sdk.options.PipelineOptions
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.Create
import org.apache.beam.sdk.transforms.MapElements
import org.apache.beam.sdk.transforms.SimpleFunction
import org.apache.beam.sdk.values.PCollection

interface Options : PipelineOptions {
    @get:Description("Input text to print.")
    @get:Default.String("My input text")
    var inputText: String
}

class PrintElement : SimpleFunction<String, String>() {
    override fun apply(element: String): String {
        println(element)
        return element
    }
}

fun buildPipeline(pipeline: Pipeline, inputText: String): PCollection<String> =
        pipeline.apply("Create elements", Create.of("Hello", "World!", inputText))
                .apply("Print elements", MapElements.via(PrintElement()))

fun main(args: Array<String>) {
    val options = PipelineOptionsFactory.fromArgs(*args).withValidation().`as`(Options::class.java)
    val pipeline = Pipeline.create(options)
    buildPipeline(pipeline, options.inputText)
    pipeline.run().waitUntilFinish()
}
