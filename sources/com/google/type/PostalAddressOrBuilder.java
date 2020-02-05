package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface PostalAddressOrBuilder extends MessageLiteOrBuilder {
    String getAddressLines(int i);

    ByteString getAddressLinesBytes(int i);

    int getAddressLinesCount();

    List<String> getAddressLinesList();

    String getAdministrativeArea();

    ByteString getAdministrativeAreaBytes();

    String getLanguageCode();

    ByteString getLanguageCodeBytes();

    String getLocality();

    ByteString getLocalityBytes();

    String getOrganization();

    ByteString getOrganizationBytes();

    String getPostalCode();

    ByteString getPostalCodeBytes();

    String getRecipients(int i);

    ByteString getRecipientsBytes(int i);

    int getRecipientsCount();

    List<String> getRecipientsList();

    String getRegionCode();

    ByteString getRegionCodeBytes();

    int getRevision();

    String getSortingCode();

    ByteString getSortingCodeBytes();

    String getSublocality();

    ByteString getSublocalityBytes();
}
