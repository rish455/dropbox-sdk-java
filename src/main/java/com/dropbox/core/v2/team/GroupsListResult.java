/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class GroupsListResult {
    // struct GroupsListResult

    private final List<GroupSummary> groups;
    private final String cursor;
    private final boolean hasMore;

    /**
     *
     * @param groups  Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeam#membersListContinue(String)} to obtain the additional
     *     members. Must not be {@code null}.
     * @param hasMore  Is true if there are additional team members that have
     *     not been returned yet. An additional call to {@link
     *     DbxTeam#membersListContinue(String)} can retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListResult(List<GroupSummary> groups, String cursor, boolean hasMore) {
        if (groups == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        for (GroupSummary x : groups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = groups;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<GroupSummary> getGroups() {
        return groups;
    }

    /**
     * Pass the cursor into {@link DbxTeam#membersListContinue(String)} to
     * obtain the additional members.
     *
     * @return value for this field, never {@code null}.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there are additional team members that have not been returned
     * yet. An additional call to {@link DbxTeam#membersListContinue(String)}
     * can retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupsListResult other = (GroupsListResult) obj;
            return ((this.groups == other.groups) || (this.groups.equals(other.groups)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupsListResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupsListResult> _JSON_WRITER = new JsonWriter<GroupsListResult>() {
        public final void write(GroupsListResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupsListResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupsListResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("groups");
            g.writeStartArray();
            for (GroupSummary item: x.groups) {
                if (item != null) {
                    GroupSummary._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("cursor");
            g.writeString(x.cursor);
            g.writeFieldName("has_more");
            g.writeBoolean(x.hasMore);
        }
    };

    public static final JsonReader<GroupsListResult> _JSON_READER = new JsonReader<GroupsListResult>() {
        public final GroupsListResult read(JsonParser parser) throws IOException, JsonReadException {
            GroupsListResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupsListResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<GroupSummary> groups = null;
            String cursor = null;
            Boolean hasMore = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("groups".equals(fieldName)) {
                    groups = JsonArrayReader.mk(GroupSummary._JSON_READER)
                        .readField(parser, "groups", groups);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else if ("has_more".equals(fieldName)) {
                    hasMore = JsonReader.BooleanReader
                        .readField(parser, "has_more", hasMore);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (groups == null) {
                throw new JsonReadException("Required field \"groups\" is missing.", parser.getTokenLocation());
            }
            if (cursor == null) {
                throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
            }
            if (hasMore == null) {
                throw new JsonReadException("Required field \"has_more\" is missing.", parser.getTokenLocation());
            }
            return new GroupsListResult(groups, cursor, hasMore);
        }
    };
}