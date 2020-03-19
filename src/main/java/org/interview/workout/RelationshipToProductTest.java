package org.interview.workout;

public class RelationshipToProductTest {


    public static void main(String[] args) {

        if (RelationshipToProduct.CHILD.equals(RelationshipToProduct.getRelationshipToProductFromName("child")))
            System.out.println("Found child");
    }
}
