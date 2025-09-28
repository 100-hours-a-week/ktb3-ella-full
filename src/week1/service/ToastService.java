package week1.service;

import week1.view.OutView;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ToastService {

    private final BreadToaster breadToaster;
    private final OutView outView;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Future<String> activeToastJob;

    public ToastService(BreadToaster breadToaster, OutView outView) {
        this.breadToaster = breadToaster;
        this.outView = outView;
    }


    public void startToasting() {
        if (this.activeToastJob == null || this.activeToastJob.isDone()) {
            this.activeToastJob = executorService.submit(breadToaster::breadToast);
        }
    }

    public void awaitToastingComplete() {
        if (activeToastJob == null) {
            return;
        }

        try {
            String result = activeToastJob.get();
            outView.printBreadReadyMessage(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            outView.printBreadToastError();
        } catch (ExecutionException e) {
            outView.printBreadToastError();
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}