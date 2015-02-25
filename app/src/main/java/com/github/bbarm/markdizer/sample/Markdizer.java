/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Minsoo Park
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.bbarm.markdizer.sample;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;

import java.util.regex.Pattern;

public class Markdizer {

    /**
     * Usage
     *
     * Bold : `*blah blah*`
     * Italic : `_blah blah_`
     * Font Color : `e74c3c#blah blah#`
     *
     * @param pattern Not spanned text
     * @return Spanned text
     */
    public static Spanned markdize(CharSequence pattern) {
        String patternStr = pattern.toString();

        if (patternStr.contains("`*") && patternStr.contains("*`")) {
            patternStr = patternStr.replace("`*", "<b>").replace("*`", "</b>");
        }

        if (patternStr.contains("`_") && patternStr.contains("_`")) {
            patternStr = patternStr.replace("`_", "<i>").replace("_`", "</i>");
        }

        Pattern regex = Pattern.compile("`([a-fA-F0-9]{3}|[a-fA-F0-9]{6})#(.+?)#`");
        if (patternStr.matches(regex.toString())) {
            patternStr = regex.matcher(patternStr).replaceAll("<font color=\"#$1\">$2</font>");
        }

        return Html.fromHtml(patternStr);
    }

    public static Spanned markdize(Context context, int resId) {
        return markdize(context.getString(resId));
    }
}