package org.apache.usergrid.persistence.collection.mvcc.stage.write;


import org.apache.usergrid.persistence.collection.mvcc.entity.MvccEntity;
import org.apache.usergrid.persistence.collection.mvcc.stage.IoEvent;
import org.apache.usergrid.persistence.collection.util.EntityUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import rx.Observable;
import rx.util.functions.Func1;


/** This phase should execute any verification on the MvccEntity */
@Singleton
public class WriteVerify implements Func1<IoEvent<MvccEntity>, IoEvent<MvccEntity>> {

    @Inject
    public WriteVerify() {
    }


    @Override
    public IoEvent<MvccEntity> call( final IoEvent<MvccEntity> mvccEntityIoEvent ) {
        EntityUtils.verifyMvccEntityWithEntity(mvccEntityIoEvent.getEvent());

        //no op, just emit the value
        return mvccEntityIoEvent;
    }
}
