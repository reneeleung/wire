// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: foreign.proto
package com.squareup.wire.protos.kotlin.foreign

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireField
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

class ForeignMessage(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  @JvmField
  val i: Int? = null,
  @field:WireField(
    tag = 100,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  @JvmField
  val j: Int? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ForeignMessage, ForeignMessage.Builder>(ADAPTER, unknownFields) {
  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.i = i
    builder.j = j
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ForeignMessage) return false
    return unknownFields == other.unknownFields
        && i == other.i
        && j == other.j
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + i.hashCode()
      result = result * 37 + j.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (i != null) result += """i=$i"""
    if (j != null) result += """j=$j"""
    return result.joinToString(prefix = "ForeignMessage{", separator = ", ", postfix = "}")
  }

  fun copy(
    i: Int? = this.i,
    j: Int? = this.j,
    unknownFields: ByteString = this.unknownFields
  ): ForeignMessage = ForeignMessage(i, j, unknownFields)

  class Builder : Message.Builder<ForeignMessage, Builder>() {
    @JvmField
    var i: Int? = null

    @JvmField
    var j: Int? = null

    fun i(i: Int?): Builder {
      this.i = i
      return this
    }

    fun j(j: Int?): Builder {
      this.j = j
      return this
    }

    override fun build(): ForeignMessage = ForeignMessage(
      i = i,
      j = j,
      unknownFields = buildUnknownFields()
    )
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ForeignMessage> = object : ProtoAdapter<ForeignMessage>(
      FieldEncoding.LENGTH_DELIMITED, 
      ForeignMessage::class
    ) {
      override fun encodedSize(value: ForeignMessage): Int = 
        ProtoAdapter.INT32.encodedSizeWithTag(1, value.i) +
        ProtoAdapter.INT32.encodedSizeWithTag(100, value.j) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: ForeignMessage) {
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i)
        ProtoAdapter.INT32.encodeWithTag(writer, 100, value.j)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ForeignMessage {
        var i: Int? = null
        var j: Int? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> i = ProtoAdapter.INT32.decode(reader)
            100 -> j = ProtoAdapter.INT32.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ForeignMessage(
          i = i,
          j = j,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ForeignMessage): ForeignMessage = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
