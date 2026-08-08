package net.morthen.template.service.platform;

import java.nio.file.Path;

public interface IPlatformHelper {
    Path getConfigDir();

    boolean isModLoaded(String modId);

    boolean isDev();

    String getName();
}
