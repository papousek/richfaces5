/**
 * License Agreement.
 *
 *  JBoss RichFaces - Ajax4jsf Component Library
 *
 * Copyright (C) 2007  Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */
package org.richfaces.ui.images;

import org.richfaces.skin.Skin;

import javax.faces.context.FacesContext;

public class StandardButtonBgImage extends BaseControlBackgroundImage {
    @Override
    protected void initializeProperties(FacesContext context, Skin skin) {
        super.initializeProperties(context, skin);
        setHeight((int) (1.7 * skin.getIntegerParameter(context, Skin.BUTTON_SIZE_FONT)));
        setBaseColorParam(Skin.ADDITIONAL_BACKGROUND_COLOR);
        setGradientColorParam(Skin.TRIM_COLOR);
        setHeight(9);
    }
}
