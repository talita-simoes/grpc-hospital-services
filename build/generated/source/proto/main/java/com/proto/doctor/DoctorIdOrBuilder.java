// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: doctor/doctor.proto

package com.proto.doctor;

public interface DoctorIdOrBuilder extends
    // @@protoc_insertion_point(interface_extends:doctor.DoctorId)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool is_available = 1;</code>
   * @return The isAvailable.
   */
  boolean getIsAvailable();

  /**
   * <code>string first_name = 2;</code>
   * @return The firstName.
   */
  java.lang.String getFirstName();
  /**
   * <code>string first_name = 2;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string last_name = 3;</code>
   * @return The lastName.
   */
  java.lang.String getLastName();
  /**
   * <code>string last_name = 3;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>string specialty = 4;</code>
   * @return The specialty.
   */
  java.lang.String getSpecialty();
  /**
   * <code>string specialty = 4;</code>
   * @return The bytes for specialty.
   */
  com.google.protobuf.ByteString
      getSpecialtyBytes();
}