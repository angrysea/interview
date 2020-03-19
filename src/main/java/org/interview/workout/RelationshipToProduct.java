package org.interview.workout;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public enum RelationshipToProduct {
    NONE("none"), PARENT("parent"), CHILD("child");

    private static final RelationshipToProduct DEFAULT_RELATIONSHIP_TYPE = RelationshipToProduct.NONE;

    public Set<String> getRelationshipToProductNames() {
        return relationshipToProductNames;
    }

    private static final EnumSet<RelationshipToProduct> relationshipToProductEnumSet =
            EnumSet.allOf(RelationshipToProduct.class);

    private final Set<String> relationshipToProductNames;

    RelationshipToProduct(final String... languageCodeNames) {
        this.relationshipToProductNames = new HashSet<>(Arrays.asList(languageCodeNames));
    }

    public static RelationshipToProduct getRelationshipToProductFromName(final String relationshipTypeName) {
        if (relationshipTypeName == null) {
            return DEFAULT_RELATIONSHIP_TYPE;
        }
        for (final RelationshipToProduct relationshipToProduct : values()) {
            if (relationshipToProduct.relationshipToProductNames.contains(relationshipTypeName.replace(" ", ""))) {
                return relationshipToProduct;
            }
        }
        return DEFAULT_RELATIONSHIP_TYPE;
    }

    public static RelationshipToProduct getRelationshipToProductEnum(final String sContentType) {
        for (final RelationshipToProduct relationshipToProduct : values()) {
            if (relationshipToProduct.name().equalsIgnoreCase(sContentType)) {
                return relationshipToProduct;
            }
        }
        return DEFAULT_RELATIONSHIP_TYPE;
    }
}
