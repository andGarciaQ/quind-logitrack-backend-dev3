package co.com.quind.logitrack.domain.model.ports.inbound;

import co.com.quind.logitrack.domain.model.Package;

public interface PackageHandler {

    Package createPackage(final Package model);

}
