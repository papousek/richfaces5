package org.richfaces.ui.dataTable;

import java.net.URL;
import java.util.List;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.richfaces.deployment.FrameworkDeployment;
import org.richfaces.shrinkwrap.descriptor.FaceletAsset;
import org.richfaces.ui.extendedDataTable.IterationBean;

@RunAsClient
@RunWith(Arquillian.class)
public class IT_RF12684 {

    @Drone
    private WebDriver browser;

    @ArquillianResource
    private URL contextPath;

    @FindBy(className = "rf-ds-btn-last")
    private WebElement lastButton;

    @Deployment
    public static WebArchive createDeployment() {
        FrameworkDeployment deployment = new FrameworkDeployment(IT_RF12684.class);
        deployment.archive().addClass(IterationBean.class);
        addIndexPage(deployment);

        return deployment.getFinalArchive();
    }

    @Test
    public void check_number_of_items_on_last_page() throws InterruptedException {
        // given
        browser.get(contextPath.toExternalForm());
        Graphene.guardXhr(lastButton).click();
        Thread.sleep(200);
        List<WebElement> cells = browser.findElements(By.cssSelector(".rf-dt-c"));
        Assert.assertEquals(1, cells.size());
    }

    private static void addIndexPage(FrameworkDeployment deployment) {
        FaceletAsset p = new FaceletAsset();
        p.form("<r:dataTable id='tableId' value='#{iterationBean.values}' var='bean' rows='3'> ");
        p.form("    <r:collapsibleSubTable id='collapsibleTableId' rows='3' /> ");
        p.form("    <r:column> ");
        p.form("        <f:facet name='header'> ");
        p.form("            <h:outputText value='Header' styleClass='tableHeader' /> ");
        p.form("        </f:facet> ");
        p.form("        <h:outputText value='#{bean}' /> ");
        p.form("    </r:column> ");
        p.form("    <f:facet name='footer'> ");
        p.form("        <r:dataScroller id='datascrollerId' for='tableId' fastControls='hide' /> ");
        p.form("    </f:facet> ");
        p.form("</r:dataTable> ");

        deployment.archive().addAsWebResource(p, "index.xhtml");
    }

}
