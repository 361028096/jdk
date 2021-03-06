/*
 * Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 8198882
 * @summary Tests that we can get the attributes of a DNS entry by naming
 *          specific RRs by their type codes and "IN" for internet class.
 *          Omit NAPTR for now because bind doesn't support it.
 * @modules java.base/sun.security.util
 * @library ../lib/
 * @run main GetNumericIRRs
 */

import javax.naming.directory.Attributes;

public class GetNumericIRRs extends GetRRsBase {

    public static void main(String[] args) throws Exception {
        new GetNumericIRRs().run(args);
    }

    /*
     * Tests that we can get the attributes of a DNS entry by naming
     * specific RRs by their type codes and "IN" for internet class.
     * Omit NAPTR for now because bind doesn't support it.
     */
    @Override public void runTest() throws Exception {
        initContext();

        for (int i = 0; i < ROOT_LIMIT; i++) {
            Attributes retAttrs = getAttributes(getKeys()[i], getNumAttrs()[i]);
            verifyAttributes(retAttrs, getAttrs()[i]);
        }

        switchToRootUrl();

        for (int i = ROOT_LIMIT; i < getKeys().length; i++) {
            Attributes retAttrs = getAttributes(getKeys()[i], getNumAttrs()[i]);
            verifyAttributes(retAttrs, getAttrs()[i]);
        }
    }
}
