package water.testframework.onenode;

import org.testng.annotations.BeforeSuite;
import water.H2O;

public class OneNodeSetup {
  public OneNodeSetup() {
  }

  /**
   * Start 1 leader node.
   *
   * The primary node blocks for cloud initialization and runs the test
   * program flow inside TestNG.
   */
  @BeforeSuite(groups={"setupCloud"})
  public void setupCloud() {
    System.out.println("OneNodeSetup called...");

    // Leader node, where the tests execute from.
    H2O.main(new String[]{});
    H2O.waitForCloudSize(1, 10000);

    System.out.println("Created");
  }
}