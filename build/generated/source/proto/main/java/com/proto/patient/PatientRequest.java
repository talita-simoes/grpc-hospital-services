// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: patient/patient.proto

package com.proto.patient;

/**
 * Protobuf type {@code patient.PatientRequest}
 */
public final class PatientRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:patient.PatientRequest)
    PatientRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PatientRequest.newBuilder() to construct.
  private PatientRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PatientRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PatientRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PatientRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.proto.patient.PatientId.Builder subBuilder = null;
            if (patientId_ != null) {
              subBuilder = patientId_.toBuilder();
            }
            patientId_ = input.readMessage(com.proto.patient.PatientId.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(patientId_);
              patientId_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.proto.patient.Patient.internal_static_patient_PatientRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.proto.patient.Patient.internal_static_patient_PatientRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.proto.patient.PatientRequest.class, com.proto.patient.PatientRequest.Builder.class);
  }

  public static final int PATIENTID_FIELD_NUMBER = 1;
  private com.proto.patient.PatientId patientId_;
  /**
   * <code>.patient.PatientId patientId = 1;</code>
   * @return Whether the patientId field is set.
   */
  @java.lang.Override
  public boolean hasPatientId() {
    return patientId_ != null;
  }
  /**
   * <code>.patient.PatientId patientId = 1;</code>
   * @return The patientId.
   */
  @java.lang.Override
  public com.proto.patient.PatientId getPatientId() {
    return patientId_ == null ? com.proto.patient.PatientId.getDefaultInstance() : patientId_;
  }
  /**
   * <code>.patient.PatientId patientId = 1;</code>
   */
  @java.lang.Override
  public com.proto.patient.PatientIdOrBuilder getPatientIdOrBuilder() {
    return getPatientId();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (patientId_ != null) {
      output.writeMessage(1, getPatientId());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (patientId_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPatientId());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.proto.patient.PatientRequest)) {
      return super.equals(obj);
    }
    com.proto.patient.PatientRequest other = (com.proto.patient.PatientRequest) obj;

    if (hasPatientId() != other.hasPatientId()) return false;
    if (hasPatientId()) {
      if (!getPatientId()
          .equals(other.getPatientId())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPatientId()) {
      hash = (37 * hash) + PATIENTID_FIELD_NUMBER;
      hash = (53 * hash) + getPatientId().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.proto.patient.PatientRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.patient.PatientRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.patient.PatientRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.patient.PatientRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.patient.PatientRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.patient.PatientRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.patient.PatientRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.patient.PatientRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.patient.PatientRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.proto.patient.PatientRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.patient.PatientRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.patient.PatientRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.proto.patient.PatientRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code patient.PatientRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:patient.PatientRequest)
      com.proto.patient.PatientRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.proto.patient.Patient.internal_static_patient_PatientRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.proto.patient.Patient.internal_static_patient_PatientRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.proto.patient.PatientRequest.class, com.proto.patient.PatientRequest.Builder.class);
    }

    // Construct using com.proto.patient.PatientRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (patientIdBuilder_ == null) {
        patientId_ = null;
      } else {
        patientId_ = null;
        patientIdBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.proto.patient.Patient.internal_static_patient_PatientRequest_descriptor;
    }

    @java.lang.Override
    public com.proto.patient.PatientRequest getDefaultInstanceForType() {
      return com.proto.patient.PatientRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.proto.patient.PatientRequest build() {
      com.proto.patient.PatientRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.proto.patient.PatientRequest buildPartial() {
      com.proto.patient.PatientRequest result = new com.proto.patient.PatientRequest(this);
      if (patientIdBuilder_ == null) {
        result.patientId_ = patientId_;
      } else {
        result.patientId_ = patientIdBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.proto.patient.PatientRequest) {
        return mergeFrom((com.proto.patient.PatientRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.proto.patient.PatientRequest other) {
      if (other == com.proto.patient.PatientRequest.getDefaultInstance()) return this;
      if (other.hasPatientId()) {
        mergePatientId(other.getPatientId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.proto.patient.PatientRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.proto.patient.PatientRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.proto.patient.PatientId patientId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.proto.patient.PatientId, com.proto.patient.PatientId.Builder, com.proto.patient.PatientIdOrBuilder> patientIdBuilder_;
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     * @return Whether the patientId field is set.
     */
    public boolean hasPatientId() {
      return patientIdBuilder_ != null || patientId_ != null;
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     * @return The patientId.
     */
    public com.proto.patient.PatientId getPatientId() {
      if (patientIdBuilder_ == null) {
        return patientId_ == null ? com.proto.patient.PatientId.getDefaultInstance() : patientId_;
      } else {
        return patientIdBuilder_.getMessage();
      }
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     */
    public Builder setPatientId(com.proto.patient.PatientId value) {
      if (patientIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        patientId_ = value;
        onChanged();
      } else {
        patientIdBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     */
    public Builder setPatientId(
        com.proto.patient.PatientId.Builder builderForValue) {
      if (patientIdBuilder_ == null) {
        patientId_ = builderForValue.build();
        onChanged();
      } else {
        patientIdBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     */
    public Builder mergePatientId(com.proto.patient.PatientId value) {
      if (patientIdBuilder_ == null) {
        if (patientId_ != null) {
          patientId_ =
            com.proto.patient.PatientId.newBuilder(patientId_).mergeFrom(value).buildPartial();
        } else {
          patientId_ = value;
        }
        onChanged();
      } else {
        patientIdBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     */
    public Builder clearPatientId() {
      if (patientIdBuilder_ == null) {
        patientId_ = null;
        onChanged();
      } else {
        patientId_ = null;
        patientIdBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     */
    public com.proto.patient.PatientId.Builder getPatientIdBuilder() {
      
      onChanged();
      return getPatientIdFieldBuilder().getBuilder();
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     */
    public com.proto.patient.PatientIdOrBuilder getPatientIdOrBuilder() {
      if (patientIdBuilder_ != null) {
        return patientIdBuilder_.getMessageOrBuilder();
      } else {
        return patientId_ == null ?
            com.proto.patient.PatientId.getDefaultInstance() : patientId_;
      }
    }
    /**
     * <code>.patient.PatientId patientId = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.proto.patient.PatientId, com.proto.patient.PatientId.Builder, com.proto.patient.PatientIdOrBuilder> 
        getPatientIdFieldBuilder() {
      if (patientIdBuilder_ == null) {
        patientIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.proto.patient.PatientId, com.proto.patient.PatientId.Builder, com.proto.patient.PatientIdOrBuilder>(
                getPatientId(),
                getParentForChildren(),
                isClean());
        patientId_ = null;
      }
      return patientIdBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:patient.PatientRequest)
  }

  // @@protoc_insertion_point(class_scope:patient.PatientRequest)
  private static final com.proto.patient.PatientRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.proto.patient.PatientRequest();
  }

  public static com.proto.patient.PatientRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PatientRequest>
      PARSER = new com.google.protobuf.AbstractParser<PatientRequest>() {
    @java.lang.Override
    public PatientRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PatientRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PatientRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PatientRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.proto.patient.PatientRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

