package org.interview.misc;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class RelationshipTypeTest {
    static public enum RelationshipType {
        NONE("none"), COMPONENT("component"), SERIES("series"),
        SEASON("season"), EPISODE("episode");

        private static final RelationshipType DEFAULT_RELATIONSHIP_TYPE = RelationshipType.NONE;

        private static final EnumSet<RelationshipType> relationshipToProductEnumSet =
                EnumSet.allOf(RelationshipType.class);

        private final Set<String> relationshipToProductNames;

        RelationshipType(final String... languageCodeNames) {
            this.relationshipToProductNames = new HashSet<>(Arrays.asList(languageCodeNames));
        }

        public static RelationshipType getRelationshipToProductFromName(final String relationshipTypeName) {
            if (relationshipTypeName == null) {
                return DEFAULT_RELATIONSHIP_TYPE;
            }
            for (final RelationshipType relationshipToProduct : values()) {
                if (relationshipToProductEnumSet.contains(relationshipTypeName.replace(" ", ""))) {
                    return relationshipToProduct;
                }
            }
            return DEFAULT_RELATIONSHIP_TYPE;
        }

        public static RelationshipType getLanguageCodeEnum(final String sContentType) {
            for (final RelationshipType relationshipToProduct : values()) {
                if (relationshipToProduct.name().equalsIgnoreCase(sContentType)) {
                    return relationshipToProduct;
                }
            }
            return DEFAULT_RELATIONSHIP_TYPE;
        }
    }

    public static void main(String[] args) {
        boolean ret = false;
        RelationshipType type = RelationshipType.EPISODE;
        boolean ret2 = RelationshipType.EPISODE.toString().equalsIgnoreCase("episode");
        ret = "episode".equals(type);
        System.out.println(ret);
    }
}
