/**
 *
 */
package org.richfaces.ui.validation;

import org.richfaces.javascript.JSLiteral;
import org.richfaces.javascript.ScriptWithDependencies;
import org.richfaces.resource.ResourceKey;

import java.util.Collections;

/**
 * This class represents "dummy" converter call ( just refference to "value" variable )
 *
 * @author asmirnov
 *
 */
public class NullConverterScript extends JSLiteral implements ScriptWithDependencies {
    private String name;

    public NullConverterScript() {
        super(ClientValidatorRenderer.VALUE_VAR);
    }

    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.richfaces.renderkit.html.LibraryScriptString#getResource()
     */
    public Iterable<ResourceKey> getResources() {
        return Collections.emptySet();
    }
}
