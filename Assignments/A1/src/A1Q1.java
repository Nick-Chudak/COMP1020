/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 1
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */



public class A1Q1 {
    
    public static void main(String[] args) throws Exception {
       
        // Artifact artifact1 = new Artifact("", 10, true);
        // Artifact artifact2 = new Artifact("My artifact", 3, false);

        // System.out.println(artifact1.getName());
        // System.out.println(artifact1.getRarity());
        // System.out.println(artifact1.getTotalArtifacts());
        // System.out.println(artifact1.useArtifact());
        // System.out.println(artifact1);
        
        // Valid artifact
        Artifact artifact1 = new Artifact("Excalibur", 5, false);
        System.out.println(artifact1); // Artifact{name='Excalibur', rarity=5, isCursed=fals
        System.out.println(artifact1.useArtifact()); // You use the Excalibur artifact. It g
        // Invalid artifact name
        Artifact artifact2 = new Artifact("", 3, true);

        // Output: Error: Artifact name cannot be null or empty
        System.out.println(artifact2); // Artifact{name='Unknown', rarity=3, isCursed=true}
        // Invalid rarity
        Artifact artifact3 = new Artifact("Pandora's Box", 0, true);
        // Output: Error: Rarity must be between 1 and 5
        System.out.println(artifact3); // Artifact{name='Pandora's Box', rarity=1, isCursed=
        // Both invalid
        Artifact artifact4 = new Artifact(null, 6, false);
        // Output:
        // Error: Artifact name cannot be null or empty
        // Error: Rarity must be between 1 and 5
        System.out.println(artifact4); // Artifact{name='Unknown', rarity=1, isCursed=false}
        // Static method usage
        System.out.println("Total artifacts created: " + Artifact.getTotalArtifacts());
        // Output: Total artifacts created: 4
        }
}
