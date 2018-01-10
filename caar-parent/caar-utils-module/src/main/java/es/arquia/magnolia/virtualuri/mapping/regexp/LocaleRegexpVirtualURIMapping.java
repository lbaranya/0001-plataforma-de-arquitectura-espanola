package es.arquia.magnolia.virtualuri.mapping.regexp;

import java.net.URI;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.context.MgnlContext;
import info.magnolia.virtualuri.mapping.RegexpVirtualUriMapping;

public class LocaleRegexpVirtualURIMapping extends RegexpVirtualUriMapping {
	private static final Logger log = LoggerFactory.getLogger(LocaleRegexpVirtualURIMapping.class);

    private Pattern regexp;

    @Override
    public void setFromUri(String fromUri) {
        setInternalFromUri(fromUri);

        if (StringUtils.isNotEmpty(fromUri)) {
            this.regexp = Pattern.compile(fromUri);
        }
    }

    @Override
    public Optional<Result> mapUri(URI uri) {

        if (regexp != null) {
            String uriString = uri.toString();
            Matcher matcher = regexp.matcher(uriString);

            if (matcher.find()) {
                try {
                    String replacedUri = matcher.replaceAll(getToUriLocalized());
                    int groupCount = matcher.groupCount() + 1;
                    Result result = new Result(replacedUri, groupCount, this);

                    return Optional.of(result);
                } catch (IndexOutOfBoundsException e) {
                    log.warn("{} misconfigured: {}", toString(), e.getMessage());
                }
            }
        }
        return Optional.empty();
    }
    
    public String getToUriLocalized() {
		String language = "";
		Locale locale = MgnlContext.getAggregationState().getLocale();
		if (locale != null) {
		  language = locale.getLanguage();
		  return this.getToUri().replace(":", ":/"+language);
		}
		return this.getToUri();
    }
}
