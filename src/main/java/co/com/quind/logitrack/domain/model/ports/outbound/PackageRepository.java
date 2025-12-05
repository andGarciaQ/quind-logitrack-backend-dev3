package co.com.quind.logitrack.domain.model.ports.outbound;

import co.com.quind.logitrack.domain.model.Package;

public interface PackageRepository {

    Package save(final Package packageToSave);

}
