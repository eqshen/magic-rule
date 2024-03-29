/**
 * The MIT License
 *
 *  Copyright (c) 2019, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.magic.rule.core.bean;

import java.util.*;

import static java.lang.String.format;

public class Facts implements Iterable<Map.Entry<String, Object>> {

    private Map<String, Object> facts = new HashMap<>();


    public Object put(String name, Object fact) {
        Objects.requireNonNull(name);
        return facts.put(name, fact);
    }

    public Object remove(String name) {
        Objects.requireNonNull(name);
        return facts.remove(name);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        Objects.requireNonNull(name);
        return (T) facts.get(name);
    }

    public Map<String, Object> asMap() {
        return facts;
    }

    @Override
    public Iterator<Map.Entry<String, Object>> iterator() {
        return facts.entrySet().iterator();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        List<Map.Entry<String, Object>> entries = new ArrayList<>(facts.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, Object> entry = entries.get(i);
            stringBuilder.append(format(" { %s : %s } ", entry.getKey(), String.valueOf(entry.getValue())));
            if (i < entries.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return  stringBuilder.toString();
    }
}
