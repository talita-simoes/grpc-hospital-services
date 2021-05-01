// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doctor/doctor.proto

package com.proto.doctor;

public final class Doctor {
  private Doctor() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_doctor_DoctorId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_doctor_DoctorId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_doctor_DoctorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_doctor_DoctorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_doctor_DoctorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_doctor_DoctorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_doctor_RegisterDoctorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_doctor_RegisterDoctorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_doctor_RegisterDoctorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_doctor_RegisterDoctorResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023doctor/doctor.proto\022\006doctor\"Z\n\010DoctorI" +
      "d\022\024\n\014is_available\030\001 \001(\010\022\022\n\nfirst_name\030\002 " +
      "\001(\t\022\021\n\tlast_name\030\003 \001(\t\022\021\n\tspecialty\030\004 \001(" +
      "\t\"3\n\rDoctorRequest\022\"\n\010doctorId\030\001 \001(\0132\020.d" +
      "octor.DoctorId\" \n\016DoctorResponse\022\016\n\006resu" +
      "lt\030\001 \001(\t\";\n\025RegisterDoctorRequest\022\"\n\010doc" +
      "torId\030\001 \001(\0132\020.doctor.DoctorId\"(\n\026Registe" +
      "rDoctorResponse\022\016\n\006result\030\001 \001(\t2\237\001\n\rDoct" +
      "orService\022;\n\006Doctor\022\025.doctor.DoctorReque" +
      "st\032\026.doctor.DoctorResponse\"\0000\001\022Q\n\016Regist" +
      "erDoctor\022\035.doctor.RegisterDoctorRequest\032" +
      "\036.doctor.RegisterDoctorResponse\"\000B\024\n\020com" +
      ".proto.doctorP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_doctor_DoctorId_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_doctor_DoctorId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_doctor_DoctorId_descriptor,
        new java.lang.String[] { "IsAvailable", "FirstName", "LastName", "Specialty", });
    internal_static_doctor_DoctorRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_doctor_DoctorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_doctor_DoctorRequest_descriptor,
        new java.lang.String[] { "DoctorId", });
    internal_static_doctor_DoctorResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_doctor_DoctorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_doctor_DoctorResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_doctor_RegisterDoctorRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_doctor_RegisterDoctorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_doctor_RegisterDoctorRequest_descriptor,
        new java.lang.String[] { "DoctorId", });
    internal_static_doctor_RegisterDoctorResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_doctor_RegisterDoctorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_doctor_RegisterDoctorResponse_descriptor,
        new java.lang.String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}