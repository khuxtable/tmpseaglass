/*
 * InternalFrameWindowFocusedState.java 07/12/12
 *
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.seaglass.state;

import java.awt.Component;
import java.awt.Window;

import javax.swing.JComponent;


/**
 */
public class RootPaneWindowFocusedState extends State {
    public RootPaneWindowFocusedState() {
        super("WindowFocused");
    }

    protected boolean isInState(JComponent c) {
        Component parent = c;
        while (parent.getParent() != null) {
            if (parent instanceof Window) {
                break;
            }
            parent = parent.getParent();
        }
        if (parent instanceof Window) {
            return ((Window) parent).isFocused();
        }
        // Default to true.
        return true;
    }
}
