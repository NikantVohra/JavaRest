package wallet.utils;

import wallet.models.Artifact;
import wallet.models.ShareProperties;

public interface Shareable<T> {
	public T share(T shareWith, Artifact artifactToShare, ShareProperties prop);
	public T[] share(T[] shareWith, Artifact artifactToShare, ShareProperties prop);
}
